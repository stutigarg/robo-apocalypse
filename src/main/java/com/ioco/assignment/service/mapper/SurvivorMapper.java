package com.ioco.assignment.service.mapper;

import com.ioco.assignment.domain.Resource;
import com.ioco.assignment.domain.Survivor;
import com.ioco.assignment.model.ResourceModel;
import com.ioco.assignment.model.SurvivorModel;
import lombok.AccessLevel;
import org.modelmapper.ModelMapper;
import com.ioco.assignment.domain.Zombie;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@lombok.NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SurvivorMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Survivor map(SurvivorModel survivorRequest) {
        Survivor survivor = new Survivor();
        survivor.setName(survivorRequest.getName());
        survivor.setAge(survivorRequest.getAge());
        survivor.setGender(survivorRequest.getGender());
        survivor.setLatitude(survivorRequest.getLocation().getLatitude());
        survivor.setLongitude(survivorRequest.getLocation().getLongitude());
        survivor.setResources(survivorRequest.getResources().stream()
                .map(rc -> SurvivorMapper.map(rc, survivor))
                .collect(Collectors.toList()));
        return survivor;
    }

    protected static Resource map(ResourceModel resourceModel, Survivor survivor) {
        Resource resource = new Resource();
        resource.setResourceType(resourceModel.getResourceType());
        resource.setQuantity(resourceModel.getQuantity());
        resource.setSurvivor(survivor);
        return resource;
    }

    public static final Zombie mapAsZombie(Survivor lostSurvivor) {
        Zombie zombie = new Zombie();
        zombie.setPersonId(lostSurvivor.getId());
        zombie.setLatitude(lostSurvivor.getLatitude());
        zombie.setLongitude(lostSurvivor.getLongitude());
        zombie.setTransformedAt(LocalDateTime.now());
        return zombie;
    }
}
