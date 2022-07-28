package cn.stuxx.workflow.service.impl;

import cn.stuxx.workflow.controller.model.DTODeployment;
import cn.stuxx.workflow.service.DeploymentService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 包名: cn.stuxx.workflow.service
 * 类名: DeploymentServiceImpl
 * 创建用户: 25789
 * 创建日期: 2022年07月29日 0:25
 * 项目名: workflow
 *
 * @author: 秦笑笑
 **/
@Service
public class DeploymentServiceImpl implements DeploymentService {
    @Autowired
    private RepositoryService repositoryService;
    @Override
    public Deployment createDeployment(DTODeployment deployment) {
        List<Deployment> list = repositoryService.createDeploymentQuery()
                .deploymentKey(deployment.getKey())
                .deploymentName(deployment.getName())
                .list();
        if (list.size() != 0){
            return list.get(0);
        }else {
            return repositoryService.createDeployment()
                    .key(deployment.getKey())
                    .name(deployment.getName())
                    .deploy();
        }
    }

    @Override
    public boolean deleteDeployment(DTODeployment deployment) {
        repositoryService.deleteDeployment(deployment.getKey());
        return true;
    }

    @Override
    public void generateImage(String key) {
    }
}