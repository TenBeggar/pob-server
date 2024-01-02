package com.tenbeggar.pob.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PageVO<T> {

    private List<T> content;
    private long total;

    public static <T> PageVO<T> build(List<T> content, long total) {
        return new PageVO<>(content, total);
    }

    public static <T> PageVO<T> build(List<?> content, Class<T> clazz, long total) {
        List<T> vos = new ArrayList<>();
        try {
            for (Object o : content) {
                T t = clazz.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(o, t);
                vos.add(t);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return new PageVO<>(vos, total);
    }

    public static <T> PageVO<T> build(Page<T> page) {
        return build(page.getContent(), page.getTotalElements());
    }

    public static <T> PageVO<T> build(Page<?> page, Class<T> clazz) {
        List<T> vos = new ArrayList<>();
        try {
            for (Object o : page.getContent()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(o, t);
                vos.add(t);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return build(vos, page.getTotalElements());
    }
}
