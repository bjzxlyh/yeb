package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李毅恒
 * @since 2021-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_employee_remove")
@Accessors(chain = true)
@ApiModel(value="EmployeeRemove对象", description="")
public class EmployeeRemove implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工id")
    private Integer eid;

    @ApiModelProperty(value = "调动后部门")
    @TableField("afterDepId")
    private Integer afterdepid;

    @ApiModelProperty(value = "调动后职位")
    @TableField("afterJobId")
    private Integer afterjobid;

    @ApiModelProperty(value = "调动日期")
    @TableField("removeDate")
    private LocalDate removedate;

    @ApiModelProperty(value = "调动原因")
    private String reason;

    @ApiModelProperty(value = "备注")
    private String remark;


}
