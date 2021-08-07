package com.xxxx.server.mapper;

import com.xxxx.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 李毅恒
 * @since 2021-08-03
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
