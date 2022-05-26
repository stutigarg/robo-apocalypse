package com.ioco.assignment.model;

import com.ioco.assignment.domain.Resource;
@lombok.Getter
@lombok.Setter
public class ResourceModel {
    private Resource.ResourceType resourceType;
    private int quantity;

}
