package co.istad.inspectra.features.documet.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record DocumentUpdate(

        String title,
        String documentDescription,
        List<String> documentImagesRequest,
        List<String> documentKeywordRequest

) {
}