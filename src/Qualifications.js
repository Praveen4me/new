import React, { useState, useEffect } from 'react';
import "./Qualifications.css";

const Qualifications = () => {
    const [isPopupOpen, setIsPopupOpen] = useState(false);
    const [userQalif, setUserQalif] = useState({
      educationBoard: '',
      collegeName: '',
      qualification: '',
      stream:'',
      yearOfPassing:'',
      CgpaOrPercentage:'',
    });
    const [user, setUser] = useState({
      employeeId: 'EMPID_002',
      employeeName: '',
      employeeEmail: ''
    });
    const [editedUser, setEditedUser] = useState({
      educationBoard: '',
      collegeName: '',
      qualification: '',
      stream:'',
      yearOfPassing:'',
      CgpaOrPercentage:'',
    });
  
    const [selectedEducationBoard, setSelectedEducationBoard] = useState(''); 

    const handleSelectChange = (e) => {
      setSelectedEducationBoard(e.target.value);
  };
    const togglePopup = () => {
      setIsPopupOpen(!isPopupOpen);
    };
  
    const handleInputChange = (e) => {
      const { name, value } = e.target;
      setEditedUser((prevUser) => ({
        ...prevUser,
        [name]: value,
      }));
    };
  
    const handleUpdate = async () => {
      try {
        const response = await fetch(`http://localhost:8081/api-v2/employee/${user.employeeId}`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(editedUser),
        });
        if (response.ok) {
          console.log('User data updated successfully');
          alert('User data updated successfully');
          setIsPopupOpen(false);
        } else {
          console.error('Failed to update user data');
          alert('Failed to update user data');
        }
      } catch (error) {
        console.error('Error updating user data:', error);
      }
    };
  
    useEffect(() => {
      fetchUserData();
    }, []);
  
    const fetchUserData = async () => {
      try {
        const response = await fetch(`http://localhost:8081/api-v2/employee/EMPID_002`);
        const userData = await response.json();
        setUser(userData);
        console.log(userData);
        setUserQalif(userData.employeeEducation);
        console.log(user.employeeEducation);
        setEditedUser(userData);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };
  
  return (
    <>
    <div style={{position:"absolute", marginTop:"-570px", marginLeft:"479px"}} className='Details_container_Qualifications'>
            
            <div className='Details'>
              <div className='d-flex justify-content-end'>
              <div className='col-md-3 '>
               
              <select
                                className='form-select form-select-sm'
                                aria-label='Small select example'
                                value={selectedEducationBoard}
                                onChange={handleSelectChange}
                            >
                                <option value='' selected disabled>
                                    Select Education Board
                                </option>
                                {/* Map over userQalif to generate option elements */}
                                {user.userQalif.map((qualification, index) => (
                                    <option key={index} value={qualification.educationBoard}>
                                        {qualification.educationBoard}
                                    </option>
                                ))}
                            </select>
              </div>
              </div>
              
              <div style={{ display: 'flex', paddingBottom: '20px' ,marginBottom:'20px', marginTop:'20px'}}>
                <label>Education Board :</label>
                <input style={{ marginLeft: '125px' }}
                  type='text'
                  placeholder='Education Board'
                  name="educationBoard"
                  value={userQalif.educationBoard}
                  onChange={handleInputChange}
                />
              </div>
              
              <div style={{ display: 'flex', paddingBottom: '20px',marginBottom:'20px' }}>
                <label>College Name :</label>
                <input style={{ marginLeft: '150px' }}
                  type='text'
                  placeholder='Enter College Name'
                  name="collegeName"
                  value={userQalif.collegeName}
                  onChange={handleInputChange}
                />
              </div>
              <div style={{ display: 'flex', paddingBottom: '20px',marginBottom:'20px' }}>
                <label>Qualification :</label>
                <input style={{ marginLeft: '156px' }}
                  type='text'
                  placeholder='Enter Qualification'
                  name="qualification"
                  value={userQalif.qualification}
                  onChange={handleInputChange}
                />
              </div>
              <div style={{ display: 'flex', paddingBottom: '20px',marginBottom:'20px'}}>
                <label>Stream :</label>
                <input style={{ marginLeft: '196px' }}
                  type='text'
                  placeholder='Enter Stream Name'
                  name="stream"
                  value={userQalif.stream}
                  onChange={handleInputChange}
                />
              </div>
              <div style={{ display: 'flex', paddingBottom: '20px' ,marginBottom:'20px' }}>
                <label>Year Of Passing :</label>
                <input style={{ marginLeft: '136px' }}
                  type='text'
                  placeholder='Enter Year Of Passing'
                  name="yearOfPassing"
                  value={userQalif.yearOfPassing}
                  onChange={handleInputChange}
                />
              </div>
              <div style={{ display: 'flex', paddingBottom: '20px',marginBottom:'20px' }}>
                <label>Cgpa / Percentage:</label>
                <input style={{ marginLeft: '116px' }}
                  type='text'
                  placeholder='Enter Cgpa Or Percentage'
                  name="CgpaOrPercentage"
                  value={userQalif.CgpaOrPercentage}
                  onChange={handleInputChange}
                />
              </div>
              <button style={{ float: 'right', width: '150px' }} className="btn btn-success" onClick={togglePopup}>Edit</button>
              {isPopupOpen && (
                <div id="popupOverlay" className="overlay-container show">
                  <div className="popup-box">
                    <form className="form-container">
                      <label className="form-label" >
                        Education Board:
                      </label>
                      <input
                        className="form-input"
                        type="text"
                        placeholder="Enter Your Board of Education"
                        name="educationBoard"
                        value={editedUser.educationBoard}
                        onChange={handleInputChange}
                        required
                      />

                      <label className="form-label" >
                      College Name:
                      </label>
                      <input
                        className="form-input"
                        type="password"
                        placeholder="Enter Your Email"
                        name="collegeName"
                        value={editedUser.collegeName}
                        onChange={handleInputChange}
                        required
                      />

                      <label className="form-label" >
                      Qualification:
                      </label>
                      <input
                        className="form-input"
                        type="text"
                        placeholder="Enter Your Aadhar ID"
                        name="qualification"
                        value={editedUser.qualification}
                        onChange={handleInputChange}
                        required
                      />

                      <label className="form-label" >
                        Role:
                      </label>
                      <input
                        className="form-input"
                        type="text"
                        placeholder="Enter Your Role"
                        name="role"
                        value={editedUser.role}
                        onChange={handleInputChange}
                        required
                      />

                      <button className="btn-submit" type="button" onClick={handleUpdate}>
                        Update
                      </button>
                    </form>

                    <button className="btn-close-popup" onClick={togglePopup}>
                      Close
                    </button>
                  </div>
                </div>
              )}
            </div>
          </div>

    
    
    </>
  );
}

export default Qualifications;
