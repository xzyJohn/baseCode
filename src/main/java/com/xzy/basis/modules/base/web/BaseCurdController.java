package com.xzy.basis.modules.base.web;

import com.github.pagehelper.Page;
import com.xzy.basis.core.utils.Result;
import com.xzy.basis.modules.base.query.PageQuery;
import com.xzy.basis.modules.base.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xzy
 * @date 2019/9/2 16:43
 */
@Validated
public abstract class BaseCurdController<T> extends BaseController {

    @Autowired
    protected IService<T> service;

    /**
     * 根据条件分页查询数据
     *
     * @param entity    条件
     * @param pageQuery 分页条件
     * @return 结果
     */
    @GetMapping
    @ResponseBody
    public Result queryList(T entity, PageQuery pageQuery) {
        List<T> list = service.queryList(entity, pageQuery);
        return Result.success(service.queryList(entity, pageQuery))
                .addExtraIfTrue(pageQuery.isCountSql(), "total", ((Page) list).getTotal());
    }

    /**
     * 根据id查询一条出局
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result query(@NotNull @PathVariable("id") Object id) {
        return Result.success(service.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param entity 新增的数据
     * @return 操作成功
     */
    @PostMapping
    @ResponseBody
    public Result create(@Validated T entity) {
        service.create(entity);
        return Result.success();
    }

    /**
     * 更新数据
     *
     * @param entity 更新的数据
     * @return 操作成功
     */
    @PutMapping
    @ResponseBody
    public Result update(@Validated T entity) {
        service.updateNotNull(entity);
        return Result.success();
    }

    /**
     * 删除数据
     *
     * @param id id
     * @return 操作成功
     */
    @DeleteMapping
    @RequestMapping
    public Result delete(@NotNull @RequestParam("id") Object id) {
        service.deleteById(id);
        return Result.success();
    }

    /**
     * 根据删除多条数据
     *
     * @param ids id
     * @return 操作成功
     */
    @PostMapping("/delete-batch")
    @ResponseBody
    public Result deleteBatchByIds(@NotNull @RequestParam("id") Object[] ids) {
        Stream.of(ids).parallel().forEach(id -> service.deleteById(id));
        return Result.success();
    }

}
