package ssm.service;

import ssm.entity.base.Entity;

public interface IThreadTask {
    void pushResouce(String resource);

    Entity getById(String id);
}
