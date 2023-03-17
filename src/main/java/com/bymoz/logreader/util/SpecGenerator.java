package com.bymoz.logreader.util;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import com.bymoz.logreader.dto.SearchColumn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpecGenerator {
    
    private static Predicate generate(String type, Root<?> root, CriteriaBuilder cb, List<SearchColumn> columns) {
        List<Predicate> predicateList = new ArrayList<>();

        for (SearchColumn column : columns) {
            predicateList.add(generate(root, cb, column));
        }

        Predicate[] predicates = predicateList.toArray(new Predicate[predicateList.size()]);

        if (type.equals("and")) {
            return cb.and(predicates);
        } else {
            return cb.or(predicates);
        }
    }

    private static Predicate generate(Root<?> root, CriteriaBuilder cb, SearchColumn column) {
        CommonUtils commonUtils = new CommonUtils();
        String columnName = column.getColumn();
        Object value = column.getValue();
        String operator = column.getOperator();
        String columnType = column.getType();

        if (columnType.equals("String")) {
            String valueString = ((String) value).trim().toLowerCase();

            if (!commonUtils.isEmpty(valueString)) {
                switch (operator) {
                    case "=":
                        return cb.equal(cb.lower(root.get(columnName)), valueString);
                    case "!=":
                        return cb.notEqual(cb.lower(root.get(columnName)), valueString);
                    case "like":
                        return cb.like(cb.lower(root.get(columnName)), "%" + valueString + "%");
                    case "!like":
                        return cb.notLike(cb.lower(root.get(columnName)), "%" + valueString + "%");
                }
            }

        } else if (columnType.equals("Integer")) {
            return cb.equal(root.get(columnName), value);
                    
        } else if (columnType.equals("Date")) {
            try {
                LocalDateTime date = commonUtils.convertToLocalDate((String) value);

                if (column.getOperator().equals(">=")) {
                    return cb.greaterThanOrEqualTo(root.get(columnName), date);

                } else if (column.getOperator().equals("<=")) {
                    return cb.lessThanOrEqualTo(root.get(columnName), date);
                } 
            } catch (Exception e) {
                log.error("Error: ", e);
            }
        }
        

        return cb.equal(root.get(columnName), value);
    }

    public static <T> Specification<T> generate(SearchColumn columns) {
        return (root, query, cb) -> generate(root, cb, columns);
    }

    public static <T> Specification<T> generateOr(List<SearchColumn> columns) {
        return (root, query, cb) -> generate("or", root, cb, columns);
    }

    public static <T> Specification<T> generateAnd(List<SearchColumn> columns) {
        return (root, query, cb) -> generate("and", root, cb, columns);
    }

    public static <T> Specification<T> generateOr(Specification<T> spec1, Specification<T> spec2) {
        return Specification.where(spec1).or(spec2);
    }

    public static <T> Specification<T> generateAnd(Specification<T> spec1, Specification<T> spec2) {
        return Specification.where(spec1).and(spec2);
    }

}
