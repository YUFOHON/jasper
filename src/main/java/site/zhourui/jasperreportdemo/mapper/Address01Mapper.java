package site.zhourui.jasperreportdemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
/**
 * @Description address mapper
 * @author: bruce
 * @date 2024/06/30
 */
@Mapper
public interface Address01Mapper<T,P> extends BaseMapper {
    /**
     * base on id querry
     */
	 T selectById(@Param("id") Integer id);

    /**
     * base on id update
     */
	 Integer updateById(@Param("bean") T t, @Param("id") Integer id);

    /**
     * base on id delete
     */
	 Integer deleteById(@Param("id") Integer id);

}