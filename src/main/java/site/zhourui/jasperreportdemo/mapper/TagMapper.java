package site.zhourui.jasperreportdemo.mapper;

import org.apache.ibatis.annotations.Param;

public interface TagMapper <T,P> extends BaseMapper {

    T selectById(@Param("id") Integer id);

    Integer updateById(@Param("bean") T t, @Param("id") Integer id);

    Integer deleteById(@Param("id") Integer id);
}
