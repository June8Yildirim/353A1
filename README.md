# Assignment 1

CREATE DATABASE school_mgmt;
USE school_mgmt;

CREATE TABLE Student (
sId INT,
name varchar(120),
major varchar(10),
PRIMARY KEY(sId)
);

INSERT INTO Student (sId, name, major) VALUES
(101, 'Alice Johnson', 'CS'),
(102, 'Bob Smith', 'Math'),
(103, 'Charlie Davis', 'Physics'),
(104, 'Diana Prince', 'Biology'),
(105, 'Edward Norton', 'CS');

Select \* from Student;

CREATE TABLE Enrolled (
cId INT,
sId INT,
PRIMARY KEY (cId, sId),
FOREIGN KEY (sId) REFERENCES Student(sId)
);

INSERT INTO Enrolled (cId, sId) VALUES
(201, 101), -- Alice in CS 201
(201, 105), -- Edward in CS 201
(202, 102), -- Bob in Math 202
(203, 103), -- Charlie in Physics 203
(201, 104); -- Diana in CS 201

Select \* from Enrolled;

Select Name, cId from Student, Enrolled where Student.sId = Enrolled.sId;

## Code Complexity

### **Code Complexity**

**Flat Files:**

- **More Complex:** Requires manual parsing and custom error handling for specific file formats.
- **Poor Readability:** Raw data in files is often difficult to read and interpret directly.
- **Manual Processes:** Data type conversion and validation must be implemented manually for every field.

**Database:**

- **Less Complex:** The database engine handles core tasks like validation, error handling, and type conversion.
- **Easy Visualization:** Data can be easily viewed with simple queries that return clearly labeled columns.
- **Efficiency:** Performance is optimized by the database, often operating close to O(log n) for indexed queries.

### **Query Flexibility**

**Flat Files:**

- Each new query type requires writing new code.
- Modifying requirements is difficult.
- Dynamically adding filters, aggregations, or sorting is complex to implement.

**Database:**

- Queries can be modified easily without changing application code.
- Offers a rich, declarative language (SQL) to enhance queries with keywords like `WHERE`, `GROUP BY`, and `HAVING`.
- Supports complex operations, enabling more powerful and accurate data analysis.

### **Performance**

**Flat Files:**

- Requires a full scan of the entire file for most queries.
- No support for indexing or optimized views.
- Performance degrades quickly, often to O(n²) or worse as data volume or query complexity increases.
- Concurrency is problematic; typically, only one client can safely write at a time either same column or not.
- Difficult to ensure data consistency.
- Cannot scale to handle high request volumes (e.g., business-level loads of thousands of requests per second).
- Risk of total data loss if the single file is corrupted.
- Less secure; files can be easily copied and stolen.

**Database:**

- Built-in support for multiple concurrent users.
- Provides indexing, materialized views, and query optimization.
- Often includes caching mechanisms for frequent queries.
- Offers secure, persistent storage with access controls.
- Designed to handle high concurrency (e.g., millions of requests per second with proper architecture).
- Ensures data integrity through ACID transactions.

### **Implementation Effort**

**Flat Files:**

- Initial setup is simple: just create a text file.
- Requires writing custom methods for all input/output and data processing operations.

**Database:**

- Has a learning curve but offers large community support.
- Implementation often simplifies to creating a connection and executing queries, with the DBMS handling the complex logic.

### **Debugging and Maintenance**

**Flat Files:**

- Very difficult to debug due to a lack of built-in tools.
- Fixing erroneous data entries is often a manual, error-prone process.
- Adding new features typically requires extensive code changes.

**Database:**

- Provides clear error messages for broken queries or invalid operations.
- Easy to optimize (e.g., by adding an index).
- Complex logic can be broken down into simpler, testable queries or stored procedures.
- Supports transactions and data integrity constraints to maintain correctness.

### **Long-Term Maintenance**

**Flat Files:**

- Schema changes require extensive manual work and code updates.
- Migration tools are essentially custom scripts that rewrite the entire codebase.
- Relies on manual backup/recovery procedures, which risk data corruption.
- Maintaining data consistency across changes is very challenging.

**Database:**

- Schema changes are simplified with commands like `ALTER TABLE`.
- Changes are transactional; if an error occurs, the database can roll back to protect existing data.
- Offers built-in, reliable backup and recovery tools.
- Robust migration frameworks and tools exist.
- Supports role-based access control, restricting schema changes to authorized users.
- Schema updates can often be performed with minimal or zero downtime using features like online operations or standby servers.
