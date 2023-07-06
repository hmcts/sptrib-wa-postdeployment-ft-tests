package uk.gov.hmcts.reform.wapostdeploymentfttests.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.gov.hmcts.reform.wapostdeploymentfttests.domain.entities.CamundaTask;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
    name = "camunda",
    url = "${camunda.url}"
)
@SuppressWarnings("PMD.UseObjectForClearerAPI")
public interface CamundaClient {

    String SERVICE_AUTHORIZATION = "ServiceAuthorization";

    @GetMapping(value = "/task",
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE
    )
    @ResponseBody
    List<CamundaTask> getTasksByTaskVariables(
        @RequestHeader(SERVICE_AUTHORIZATION) String serviceAuthorisation,
        @RequestParam("taskVariables") String taskVariables,
        @RequestParam(value = "sortBy", defaultValue = "created", required = false) String sortBy,
        @RequestParam(value = "sortOrder", defaultValue = "desc", required = false) String sortOrder
    );

}

