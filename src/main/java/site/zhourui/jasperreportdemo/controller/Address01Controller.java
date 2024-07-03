package site.zhourui.jasperreportdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.zhourui.jasperreportdemo.service.Address01Service;
import site.zhourui.jasperreportdemo.entity.po.Address01;
import site.zhourui.jasperreportdemo.entity.query.Address01Query;
import site.zhourui.jasperreportdemo.entity.vo.ResponseVO;
import java.util.List;
/**
 * @Description Controller
 * @author: bruce
 * @date 2024/06/30
 */
@RestController
@RequestMapping("/address01")
public class Address01Controller extends ABaseController{

  @Resource
  private Address01Service address01Service;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDataList(Address01Query query) {
        return getSuccessResponseVo(address01Service.findListByPage(query));
    }
    /**
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(Address01 bean){
        return getSuccessResponseVo(address01Service.add(bean));
	 }
    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<Address01> listBean){
        return getSuccessResponseVo(address01Service.addBatch(listBean));
	 }
    /**
     * 新增或者修改
     */
    @RequestMapping("addOrUpdate")
    public ResponseVO addOrUpdate(Address01 bean){
        return getSuccessResponseVo(address01Service.addOrUpdate(bean));
	 }
    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdate(@RequestBody List<Address01> listBean){
        return getSuccessResponseVo(address01Service.addOrUpdateBatch(listBean));
	 }
    /**
     * 根据Id查询
     */
    @RequestMapping("getAddress01ById")
	 public ResponseVO getAddress01ById(Integer id){
        return getSuccessResponseVo(this.address01Service.getById(id));
	 }
    /**
     * 根据Id更新
     */
    @RequestMapping("updateAddress01ById")
	 public ResponseVO updateAddress01ById(Address01 bean,Integer id){
        return getSuccessResponseVo(this.address01Service.updateById(bean,id));
	 }
    /**
     * 根据Id删除
     */
    @RequestMapping("deleteAddress01ById")
	 public ResponseVO deleteAddress01ById(Integer id){
        return getSuccessResponseVo(this.address01Service.deleteById(id));
	 }

}