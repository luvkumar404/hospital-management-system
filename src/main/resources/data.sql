INSERT INTO patient(name, gender, birth_date, email, blood_group)
VALUES
    ('love','male','2004-12-12','love@gmail.com', 'O_POSITIVE'),
    ('kush','male','2004-12-12','kush@gmail.com', 'A_NEGATIVE'),
    ('arman','male','2005-01-18','arman@gmail.com', 'O_NEGATIVE');

INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com'),
    ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');


INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
  ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
  ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
  ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
  ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
  ('2025-07-05 16:15:00', 'Consultation', 1, 3),
  ('2025-07-06 08:30:00', 'Allergy Treatment', 2, 2);