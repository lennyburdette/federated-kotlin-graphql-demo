/* tslint:disable */
/* eslint-disable */
// @generated
// This file was automatically generated and should not be edited.

// ====================================================
// GraphQL query operation: AppTest
// ====================================================

export interface AppTest_merchant {
  __typename: "Merchant";
  id: string;
}

export interface AppTest {
  merchant: AppTest_merchant | null;
}

export interface AppTestVariables {
  id: string;
}
