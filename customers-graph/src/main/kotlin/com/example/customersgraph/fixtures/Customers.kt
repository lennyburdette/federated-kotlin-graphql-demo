import com.example.customersgraph.types.Customer

val customers = mutableMapOf(
    "c1" to Customer(id = "c1", givenName = "Alice", familyName = "Smith"),
    "c2" to Customer(id = "c2", givenName = "Bob", familyName = "Smith"),
    "c3" to Customer(id = "c3", givenName = "Carol", familyName = "Smith"),
    "c4" to Customer(id = "c4", givenName = "Dave", familyName = "Smith"),
    "c5" to Customer(id = "c5", givenName = "Ellen", familyName = "Smith"),
    "c6" to Customer(id = "c6", givenName = "Frank", familyName = "Smith"),
    "c7" to Customer(id = "c7", givenName = "Greta", familyName = "Smith"),
    "c8" to Customer(id = "c8", givenName = "Henry", familyName = "Smith"),
    "c9" to Customer(id = "c9", givenName = "Ingrid", familyName = "Smith"),
    "c10" to Customer(id = "c10", givenName = "Jack", familyName = "Smith")
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
