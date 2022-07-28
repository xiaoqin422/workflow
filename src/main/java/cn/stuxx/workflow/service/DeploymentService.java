package cn.stuxx.workflow.service;

import cn.stuxx.workflow.controller.model.DTODeployment;
import org.activiti.engine.repository.Deployment;

/**
 * 包名: cn.stuxx.workflow.service
 * 类名: DeploymentService
 * 创建用户: 25789
 * 创建日期: 2022年07月29日 0:24
 * 项目名: workflow
 *
 * @author: 秦笑笑
 **/
public interface DeploymentService {
    Deployment createDeployment(DTODeployment deployment);
    boolean deleteDeployment(DTODeployment deployment);

    void generateImage(String key);

}
