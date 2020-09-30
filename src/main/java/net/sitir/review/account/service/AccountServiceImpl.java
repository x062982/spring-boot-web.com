package net.sitir.review.account.service;

import net.sitir.review.account.domain.AccountEntity;
import net.sitir.review.account.mapper.AccountMapper;
import net.sitir.review.account.service.IAccountService;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author ZhouWX
 * @since 2020-09-24
 */
@RestController
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountMapper mapper;

    @Override
    public Long saveAccount(AccountEntity entity) {
        Long id = Long.valueOf(mapper.insert(entity));
        if (id > 0) {
            id = entity.getId();
        }
        return id;
    }

    @Override
    public Integer updAccountById(AccountEntity entity) {
        return mapper.updateById(entity);
    }

    @Override
    public Integer delAccountById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public AccountEntity getAccountById(Long id) {
       return mapper.selectById(id);
    }

    @Override
    public List<AccountEntity> getAccounts() {
        return mapper.selectList(null);
    }

}

