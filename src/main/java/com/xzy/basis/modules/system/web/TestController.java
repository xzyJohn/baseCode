package com.xzy.basis.modules.system.web;

import com.xzy.basis.core.annotation.SystemLog;
import com.xzy.basis.core.utils.Result;
import com.xzy.basis.modules.base.query.PageQuery;
import com.xzy.basis.modules.base.web.BaseCurdController;
import com.xzy.basis.modules.system.po.BasisUser;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author xzy
 * @date 2019/9/3 9:42
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseCurdController<BasisUser> {
    @Override
    @GetMapping
    @SystemLog
    public Result queryList(BasisUser entity, PageQuery pageQuery) {
        return super.queryList(entity, pageQuery);
    }

    @Override
    @GetMapping("/{id}")
    @SystemLog
    public Result query(@NotNull @PathVariable("id") Object id) {
        return super.query(id);
    }

    @Override
    @PostMapping
    @SystemLog
    public Result create(@RequestBody BasisUser entity) {
        return super.create(entity);
    }

    @Override
    @PutMapping
    @SystemLog("update")
    public Result update(@RequestBody BasisUser entity) {

        return super.update(entity);
    }

    @Override
    @DeleteMapping
    @SystemLog("删除")
    public Result delete(@NotNull @RequestBody Object id) {
        return super.delete(id);
    }

    @Override
    @DeleteMapping("/{ids}")
    @SystemLog
    public Result deleteBatchByIds(@NotNull @PathVariable("ids") Object[] ids) {
        return super.deleteBatchByIds(ids);
    }
}
