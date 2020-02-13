package com.example.paymentsgraph.types

import com.example.graphcommon.types.Money
import java.time.OffsetDateTime

data class ProcessingFee(
  val amountMoney: Money,
  val effectiveAt: OffsetDateTime,
  val type: String // INITIAL, ADJUSTMENT
)
