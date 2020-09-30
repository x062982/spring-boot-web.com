package net.sitir.review.account.service;

import net.sitir.review.account.domain.AccountEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <p>
* 账户表 服务类
* </p>
*
* @author ZhouWX
* @since 2020-09-24
*/
@FeignClient("sitir-practice-base-service")
@RequestMapping("/base-practice/account")
public interface IAccountService {

    /**
    * 插入一条记录进账户表
    * @param entity    账户表实体对象
    * @return 返回插入的主键id 0：失败；> 0：成功
    */
    @PostMapping("/save-account")
    Long saveAccount(@RequestBody AccountEntity entity);

    /**
    *  根据id更新账户表的信息
    * @param entity    账户表实体对象
    * @return 0：失败；1：成功
    */
    @PostMapping("/update-account")
    Integer updAccountById(@RequestBody AccountEntity entity);

    /**
    *  根据id删除一个账户表的信息
    * @param id    编号
    * @return 0：失败；1：成功
    */
    @PostMapping("/delete-account-by-id")
    Integer delAccountById(@RequestParam Long id);

    /**
    * 根据id查询一个账户表的信息
    * @param id 编号
    * @return 一个账户表的信息
    */
    @GetMapping("/get-account-by-id")
    AccountEntity getAccountById(@RequestParam Long id);

    /**
    * 获取所有的账户表的信息
    * @return 所有的账户表的信息
    */
    @GetMapping("/get-all-account")
    List<AccountEntity> getAccounts();

}
