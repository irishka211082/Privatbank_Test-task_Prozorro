## Plan of realising the task (decomposition)

1. Create domain model, types.
2. Create database, tables. Liquibase or another way.
(1 & 2 can be done together)

3. Writing services:
- parser
- finding the type of item
- converter id of element to parent id
(all this steps can be done in parallel)

4. Creating exceptions

5. Creating dao layer.

6. Creating controller-methods, checking endpoints.

7. Writing the documentation
