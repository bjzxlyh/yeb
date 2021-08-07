package com.xxxx.server.mapper;

import com.xxxx.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 李毅恒
 * @since 2021-08-03
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
