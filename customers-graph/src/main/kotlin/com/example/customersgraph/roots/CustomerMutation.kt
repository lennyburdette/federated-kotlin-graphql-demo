package com.example.customersgraph.roots

import com.example.customersgraph.types.Customer
import com.example.graphcommon.types.Address
import com.expediagroup.graphql.annotations.GraphQLID
import com.expediagroup.graphql.spring.operations.Mutation
import getCustomer
import graphql.schema.DataFetchingEnvironment
import nextCustomerId
import org.springframework.stereotype.Component
import upsertCustomer
import java.lang.RuntimeException
import deleteCustomer as deleteCustomerFixture

data class CreateCustomerInput(
  val clientMutationId: String,

  val givenName: String? = null,
  val familyName: String? = null,
  val nickname: String? = null,
  val companyName: String? = null,
  val emailAddress: String? = null,
  val address: Address? = null,
  val phoneNumber: String? = null,
  val birthday: String? = null,
  val referenceId: String? = null,
  val note: String? = null
)

data class CreateCustomerPayload(
  val customer: Customer
)

data class UpdateCustomerInput(
  @GraphQLID val id: String,
  val clientMutationId: String,

  val givenName: String? = null,
  val familyName: String? = null,
  val nickname: String? = null,
  val companyName: String? = null,
  val emailAddress: String? = null,
  val address: Address? = null,
  val phoneNumber: String? = null,
  val birthday: String? = null,
  val referenceId: String? = null,
  val note: String? = null
)

data class UpdateCustomerPayload(
  val customer: Customer
)

data class DeleteCustomerPayload(
  val success: Boolean
)

@Component
class CustomerMutation : Mutation {
  fun createCustomer(input: CreateCustomerInput): CreateCustomerPayload {
    val c = Customer(
        id = nextCustomerId(),
        givenName = input.givenName,
        familyName = input.familyName,
        nickname = input.nickname,
        companyName = input.companyName,
        emailAddress = input.emailAddress,
        address = input.address,
        phoneNumber = input.phoneNumber,
        birthday = input.birthday,
        referenceId = input.referenceId,
        note = input.note
    )
    upsertCustomer(c)
    return CreateCustomerPayload(c)
  }

  fun updateCustomer(
    input: UpdateCustomerInput,
    env: DataFetchingEnvironment
  ): UpdateCustomerPayload {
    val c = getCustomer(input.id) ?: throw RuntimeException("Customer ${input.id} not found")

    val inputArg = env.arguments["input"] as Map<*, *>

    val newCustomer = c.copy(
        givenName = if (inputArg.containsKey("givenName")) input.givenName else c.givenName,
        familyName = if (inputArg.containsKey("familyName")) input.familyName else c.familyName,
        nickname = if (inputArg.containsKey("nickname")) input.nickname else c.nickname,
        companyName = if (inputArg.containsKey("companyName")) input.companyName else c.companyName,
        emailAddress = if (inputArg.containsKey("emailAddress"))
          input.emailAddress else c.emailAddress,
        address = if (inputArg.containsKey("address")) input.address else c.address,
        phoneNumber = if (inputArg.containsKey("phoneNumber")) input.phoneNumber else c.phoneNumber,
        birthday = if (inputArg.containsKey("birthday")) input.birthday else c.birthday,
        referenceId = if (inputArg.containsKey("referenceId")) input.referenceId else c.referenceId,
        note = if (inputArg.containsKey("note")) input.note else c.note
    )

    upsertCustomer(newCustomer)
    return UpdateCustomerPayload(newCustomer)
  }

  fun deleteCustomer(@GraphQLID id: String): DeleteCustomerPayload {
    deleteCustomerFixture(id)
    return DeleteCustomerPayload(true)
  }
}
