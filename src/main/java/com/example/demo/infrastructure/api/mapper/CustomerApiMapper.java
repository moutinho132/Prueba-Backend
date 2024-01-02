package com.example.demo.infrastructure.api.mapper;

import com.example.demo.domain.models.Customer;
import com.example.demo.infrastructure.api.request.CustomerRequest;
import com.example.demo.infrastructure.api.response.CustomerResponse;
import org.mapstruct.Mapper;
import java.util.List;

/*
*
* @Mapper(
    componentModel = "spring",
    uses = {
        CustomerStatusApiMapper.class,
        MembershipApiMapper.class,
        CompanyApiMapper.class,
        PersonApiMapper.class,
        LeadApiMapper.class,
        CustomerStatusApiMapper.class,
        UserApiMapper.class,
        CreationTypeApiMapper.class,
        PaymentDetailsApiMapper.class
    }
)*/
@Mapper(
        componentModel = "spring",
        uses = {
                PersonApiMapper.class,
                UserApiMapper.class,
        }

)
public interface CustomerApiMapper {
    Customer requestToModel(CustomerRequest request);
    List<Customer> requestToModelList(List<CustomerRequest> list);

    CustomerResponse modelToResponse(Customer model);

    List<CustomerResponse> modelsToResponseList(List<Customer> list);
}
