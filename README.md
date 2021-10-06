# javaprojects
small java programs
<h2>PatientWare v.0</h2> 
<p>PatientWare v.0 is the first version of PatientWare, a program that manages patient data for a health maintenance organization. It will model patient demographic data, doctors employed by the organization, and health data about the patients. </p>

<h3>Class HW1Driver</h3>
<p>The HW1Driver class contains the main program and one helper method. It has the static variable scanner: private static Scanner scanner – the keyboard scanner</p>

<h3>Class Patient</h3>
<p>Patient contains firstName, lastName, unique id, age, and address; in addition, it contains a reference to the patient’s Chart object</p>

<h3>Class PatientList</h3>
<p>This class contains an ArrayList of Patient objects. Its default constructor new's that ArrayList.</p>

<h3>Class HealthItem</h3>
<p>HealthItem contains data about one test or measurement for a patient; it contains the patient id, the test name, the date of the test, and the value of the test.</p>

<h3>Class Chart</h3>
<p>This class contains an ArrayList of HealthItem objects for one patient, the patient id, and a filename. Its default constructor new’s up that ArrayList.</p>