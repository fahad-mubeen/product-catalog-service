ALTER TABLE category
    ADD COLUMN description TEXT;

UPDATE category
SET description = CONCAT('Category: ', name)
WHERE description IS NULL;
