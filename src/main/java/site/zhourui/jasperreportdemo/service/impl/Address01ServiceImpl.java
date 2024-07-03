package site.zhourui.jasperreportdemo.service.impl;

import site.zhourui.jasperreportdemo.entity.query.Address01Query;
import site.zhourui.jasperreportdemo.entity.query.SimplePage;
import site.zhourui.jasperreportdemo.entity.po.Address01;
import site.zhourui.jasperreportdemo.entity.vo.PaginationResultVO;
import site.zhourui.jasperreportdemo.mapper.Address01Mapper;
import org.springframework.stereotype.Service;
import site.zhourui.jasperreportdemo.service.Address01Service;
import java.util.List;
import javax.annotation.Resource;
import site.zhourui.jasperreportdemo.entity.enums.PageSize;
/**
 * @Description 对应的ServiceImpl
 * @author: bruce
 * @date 2024/06/30
 */
@Service("address01Service")
public class Address01ServiceImpl implements Address01Service{

  @Resource
  private Address01Mapper<Address01,Address01Query>address01Mapper;
    /**
     * 根据条件查询列表
     */
    @Override
    public List<Address01>findListByParam(Address01Query query){
        return this.address01Mapper.selectList(query);
	 }
    /**
     * 根据条件查询数量
     */
    @Override
    public Integer findCountByParam(Address01Query query){
        return this.address01Mapper.selectCount(query);
	 }
    /**
     * 分页查询
     */
    @Override
    public PaginationResultVO<Address01> findListByPage(Address01Query query ){
        Integer count = this.findCountByParam(query); 
        Integer pageSize=query.getPageSize()==null? PageSize.SIZE15.getSize():query.getPageSize();
        SimplePage page=new SimplePage(query.getPageNo(),count,pageSize);
        query.setSimplePage(page);
        List<Address01> list = this.findListByParam(query);
        PaginationResultVO<Address01> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
	 }
    /**
     * 新增
     */
    @Override
    public Integer add(Address01 bean){
        return this.address01Mapper.insert(bean);
	 }
    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<Address01> listBean){
        if(listBean==null||listBean.isEmpty()){
            return 0;
        }
        return this.address01Mapper.insertBatch(listBean);
	 }
    /**
     * 新增或者修改
     */
    @Override
    public Integer addOrUpdate(Address01 bean){
        return this.address01Mapper.insertOrUpdate(bean);
	 }
    /**
     * 批量新增或修改
     */
    @Override
    public Integer addOrUpdateBatch(List<Address01> listBean){
        if(listBean==null||listBean.isEmpty()){
            return 0;
        }
        return this.address01Mapper.insertOrUpdateBatch(listBean);
	 }
    /**
     * 根据Id查询
     */
    @Override
	 public Address01 getById(Integer id){
        return this.address01Mapper.selectById(id);
	 }
    /**
     * 根据Id更新
     */
    @Override
	 public Integer updateById(Address01 bean , Integer id){
        return this.address01Mapper.updateById(bean,id);
	 }
    /**
     * 根据Id删除
     */
    @Override
	 public Integer deleteById(Integer id){
        return this.address01Mapper.deleteById(id);
	 }

}