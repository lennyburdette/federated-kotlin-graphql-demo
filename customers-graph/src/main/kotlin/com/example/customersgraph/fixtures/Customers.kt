import com.example.customersgraph.types.Customer

val customers = mutableMapOf(
    "c1" to Customer(id = "c1"),
    "c2" to Customer(id = "c2"),
    "c3" to Customer(id = "c3"),
    "c4" to Customer(id = "c4"),
    "c5" to Customer(id = "c5"),
    "c6" to Customer(id = "c6"),
    "c7" to Customer(id = "c7"),
    "c8" to Customer(id = "c8"),
    "c9" to Customer(id = "c9"),
    "c10" to Customer(id = "c10")
)

private var id = customers.size
fun nextCustomerId(): String {
  id += 1
  return "c$id"
}

fun getCustomer(id: String): Customer? {
  return customers[id]
}

fun upsertCustomer(c: Customer) {
  customers[c.id] = c
}

fun deleteCustomer(id: String) {
  customers.remove(id)
}
