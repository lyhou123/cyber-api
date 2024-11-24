package co.istad.inspectra.features.quality_gates;

import co.istad.inspectra.base.BaseRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quality-gates")
@RequiredArgsConstructor
public class QualityGatesController {

    private final QualityGatesService qualityGatesService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BaseRestResponse<Object> getQualityGatesByProjectName(String projectName) throws Exception {
        return BaseRestResponse.builder()
                .data(qualityGatesService.getQualityGatesByProjectName(projectName))
                .message("Get quality gates by project name.")
                .build();
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public BaseRestResponse<Object> getAllQualityGates() throws Exception {
        return BaseRestResponse.builder()
                .data(qualityGatesService.getAllQualityGates())
                .message("Get all quality gates.")
                .build();
    }

}
