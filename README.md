## Product Management API Documentation

This API allows users to manage products, including creating, retrieving, updating, and deleting product records.


### Base URL

```
/api/v1/products
```



### Endpoints

#### 1. **Create a New Product**
   - **Method:** `POST`
   - **URL:** `/api/v1/products/create`
   - **Description:** Creates a new product with provided details.

   ##### Request Body (JSON)
   ```
   {
     "name": "Sample Product",
     "price": 29.99,
     "description": "This is a sample product"
   }
   ```

   ##### Response
   - **Status Code:** `201 Created`
   - **Body (JSON):**
     ```
     {
       "id": 1,
       "name": "Sample Product",
       "price": 29.99,
       "description": "This is a sample product"
     }
     ```

   ##### Error Handling
   - **400 Bad Request:** If the product details are invalid.
   - **500 Internal Server Error:** If there's an issue on the server while saving the product.

---

#### 2. **Retrieve Product by ID**
   - **Method:** `GET`
   - **URL:** `/api/v1/products/{id}`
   - **Description:** Retrieves product details by its ID.

   ##### Response
   - **Status Code:** `200 OK`
   - **Body (JSON):**
     ```
     {
       "id": 1,
       "name": "Sample Product",
       "price": 29.99,
       "description": "This is a sample product"
     }
     ```

   ##### Error Handling
   - **404 Not Found:** If the product with the given ID doesn't exist.


#### 3. **Retrieve Product by Name**
   - **Method:** `GET`
   - **URL:** `/api/v1/products?name={name}`
   - **Description:** Retrieves product details by its name.

   ##### Response
   - **Status Code:** `200 OK`
   - **Body (JSON):**
     ```
     {
       "id": 1,
       "name": "Sample Product",
       "price": 29.99,
       "description": "This is a sample product"
     }
     ```

   ##### Error Handling
   - **404 Not Found:** If the product with the given name doesn't exist.

---

#### 4. **Update Product by ID**
   - **Method:** `PUT`
   - **URL:** `/api/v1/products/{id}`
   - **Description:** Updates an existing product's details by its ID.

   ##### Request Body (JSON)
   ```
   {
     "name": "Updated Product Name",
     "price": 39.99,
     "description": "Updated product description"
   }
   ```

   ##### Response
   - **Status Code:** `200 OK`
   - **Body (JSON):**
     ```
     {
       "id": 1,
       "name": "Updated Product Name",
       "price": 39.99,
       "description": "Updated product description"
     }
     ```

   ##### Error Handling
   - **404 Not Found:** If the product with the given ID doesn't exist.
   - **400 Bad Request:** If the product details are invalid.

---

#### 5. **Update Product by Name**
   - **Method:** `PUT`
   - **URL:** `/api/v1/products?name={name}`
   - **Description:** Updates an existing product's details by its name.

   ##### Request Body (JSON)
   ```
   {
     "name": "Updated Product Name",
     "price": 39.99,
     "description": "Updated product description"
   }
   ```

   ##### Response
   - **Status Code:** `200 OK`
   - **Body (JSON):**
     ```
     {
       "id": 1,
       "name": "Updated Product Name",
       "price": 39.99,
       "description": "Updated product description"
     }
     ```

   ##### Error Handling
   - **404 Not Found:** If the product with the given name doesn't exist.
   - **400 Bad Request:** If the product details are invalid.

---

#### 6. **Delete Product by ID**
   - **Method:** `DELETE`
   - **URL:** `/api/v1/products/{id}`
   - **Description:** Deletes an existing product by its ID.

   ##### Response
   - **Status Code:** `204 No Content`
   
   ##### Error Handling
   - **404 Not Found:** If the product with the given ID doesn't exist.

---

#### 7. **Delete Product by Name**
   - **Method:** `DELETE`
   - **URL:** `/api/v1/products?name={name}`
   - **Description:** Deletes an existing product by its name.

   ##### Response
   - **Status Code:** `204 No Content`
   
   ##### Error Handling
   - **404 Not Found:** If the product with the given name doesn't exist.


### Conclusion

This API provides a full range of product management operations. Users can create, update, delete, and retrieve product information by either product ID or name. Proper error handling ensures that incorrect or missing data returns meaningful error messages.
