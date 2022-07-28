package cn.stuxx.workflow.controller;

import cn.stuxx.workflow.controller.model.DTODeployment;
import cn.stuxx.workflow.service.DeploymentService;
import cn.stuxx.workflow.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 包名: cn.stuxx.workflow.controller
 * 类名: DeploymentController
 * 创建用户: 25789
 * 创建日期: 2022年07月29日 0:22
 * 项目名: workflow
 *
 * @author: 秦笑笑
 **/
@Api(tags = "流程实例创建接口")
@RestController
@RequestMapping("/deployment")
public class DeploymentController {
    @Autowired
    private DeploymentService deploymentService;

    @ApiOperation("流程实例创建")
    @PostMapping("create")
    public R createDeployment(@RequestBody DTODeployment param){
        Deployment deployment = deploymentService.createDeployment(param);
        return R.ok().put("data",deployment);
    }
}