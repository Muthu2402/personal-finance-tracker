# Help & Troubleshooting

## Common Errors

### 1. Connection Refused
- Check MySQL is running
- Verify username/password
- Check port number (3306)

### 2. TemplateInputException
- Ensure HTML file name matches controller return value
- Check file inside `templates` folder

### 3. SQLGrammarException
- Check table name
- Verify column names
- Enable `spring.jpa.hibernate.ddl-auto=update`

## Beginner Notes
- Controller handles request
- Service contains business logic
- Repository talks to database
- Model maps to database table
