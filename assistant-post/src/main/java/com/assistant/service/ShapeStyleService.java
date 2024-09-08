package com.assistant.service;

import com.assistant.domain.ShapeStyle;
import com.assistant.dto.ShapeStyleCreateRequest;
import com.assistant.repository.ShapeStyleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShapeStyleService {

    private final ShapeStyleRepository shapeStyleRepository;

    public ShapeStyleService(ShapeStyleRepository shapeStyleRepository) {
        this.shapeStyleRepository = shapeStyleRepository;
    }

    public ShapeStyle create(ShapeStyleCreateRequest shapeStyleCreateRequest) {
        return shapeStyleRepository.save(shapeStyleCreateRequest.to());
    }
}
