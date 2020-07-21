package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
<#if cfg.isExtend>import ${superServiceImplClassPackage};
<#else>import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import java.util.List;</#if>

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#elseif cfg.isExtend>public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

}
<#else>@RestController
@AllArgsConstructor
public class ${table.serviceImplName} implements ${table.serviceName} {

    private ${table.mapperName} mapper;

    @Override
    public Long save${cfg.tableLevel2?cap_first}(${entity} entity) {
        Long id = Long.valueOf(mapper.insert(entity));
        if (id > 0) {
            id = entity.getId();
        }
        return id;
    }

    @Override
    public Integer upd${cfg.tableLevel2?cap_first}ById(${entity} entity) {
        return mapper.updateById(entity);
    }

    @Override
    public Integer del${cfg.tableLevel2?cap_first}ById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public ${entity} get${cfg.tableLevel2?cap_first}ById(Long id) {
       return mapper.selectById(id);
    }

    @Override
    public List<${entity}> get${cfg.tableLevel2?cap_first}s() {
        return mapper.selectList(null);
    }

}

</#if>