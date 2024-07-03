package site.zhourui.jasperreportdemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
/**
 * @Description 对应的mapper类
 * @author: bruce
 * @date 2024/06/30
 */
@Mapper
public interface Address01Mapper<T,P> extends BaseMapper {
    /**
     * 根据Id查询
     */
	 T selectById(@Param("id") Integer id);

    /**
     * 根据Id更新
     */
	 Integer updateById(@Param("bean") T t, @Param("id") Integer id);

    /**
     * 根据Id删除
     */
	 Integer deleteById(@Param("id") Integer id);

}