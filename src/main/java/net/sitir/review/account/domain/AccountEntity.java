package net.sitir.review.account.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.KeySequence;
import org.apache.ibatis.type.JdbcType;

/**
* <p>
* 账户表
* </p>
*
* @author ZhouWX
* @since 2020-09-24
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PRACTICE_ACCOUNT")
@KeySequence(value = "SEQ_PRACTICE_ACCOUNT")
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
    * 编号
    */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
    * 用户名
    */
    @TableField(value = "NAME", jdbcType = JdbcType.VARCHAR)
    private String name;

    /**
    * 密码
    */
    @TableField(value = "PASSWORD", jdbcType = JdbcType.VARCHAR)
    private String password;

    /**
    * 角色
    */
    @TableField(value = "ROLE_ID", jdbcType = JdbcType.DOUBLE)
    private Long roleId;

}
