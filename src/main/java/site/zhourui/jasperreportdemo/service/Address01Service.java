package site.zhourui.jasperreportdemo.service;

import site.zhourui.jasperreportdemo.entity.query.Address01Query;
import site.zhourui.jasperreportdemo.entity.po.Address01;
import site.zhourui.jasperreportdemo.entity.vo.PaginationResultVO;
import java.util.List;
/**
 * @Description 对应的Service
 * @author: bruce
 * @date 2024/06/30
 */
public interface Address01Service{

    /**
     * 根据条件查询列表
     */
    List<Address01>findListByParam(Address01Query query);

    /**
     * 根据条件查询数量
     */
    Integer findCountByParam(Address01Query query);

    /**
     * 分页查询
     */
    PaginationResultVO<Address01> findListByPage(Address01Query query );

    /**
     * 新增
     */
    Integer add(Address01 bean);
    /**
     * 批量新增
     */
    Integer addBatch(List<Address01> listBean);
    /**
     * 新增或修改
     */
    Integer addOrUpdate(Address01 bean);
    /**
     * 批量新增或修改
     */
    Integer addOrUpdateBatch(List<Address01> listBean);
    /**
     * 根据Id查询
     */
	 Address01 getById(Integer id);

    /**
     * 根据Id更新
     */
	 Integer updateById(Address01 bean , Integer id);

    /**
     * 根据Id删除
     */
	 Integer deleteById(Integer id);


}