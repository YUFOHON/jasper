package site.zhourui.jasperreportdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface AddressMapper {
    List<Map<String, Object>> getAllAddresses();
}
