import React, { useState, useEffect } from 'react';
import './Experience.css';

  

const Experience = () => {
    const [isPopupOpen, setIsPopupOpen] = useState(false);
    const [user, setUser] = useState({
      employeeId: 'EMPID_002',
      companyName: '',
      designation:'',  
      
      totalExp: ''

    });
    const [editedUser, setEditedUser] = useState({
        companyName: '',
        designation:'',
        
        totalExp: ''

    });
  
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
  
    // const fetchUserData = async () => {
    //   try {
    //     const response = await fetch(`http://localhost:8081/api-v2/employee/${user.employeeId}`);
    //     const userData = await response.json();
    //     console.log(userData.employeeExperience);
    //     setUser(userData.employeeExperience);
    //     // Set edited user data initially with fetched user data
    //     setEditedUser(userData);
    //   } catch (error) {
    //     console.error('Error fetching user data:', error);
    //   }
    // };
    // const fetchUserData = async () => {
    //   try {
    //     const response = await fetch(`http://localhost:8081/api-v2/employee/${user.employeeId}`);
    //     const userData = await response.json();
        
    //     // Convert array of user data to an object
    //     const userObject = {};
    //     userData.employeeExperience.forEach((experience, index) => {
    //       userObject[index] = experience;
    //     });
    
    //     console.log(userObject);
    //     setUser(userObject);
    //     // Set edited user data initially with fetched user data
    //     setEditedUser(userData);
    //   } catch (error) {
    //     console.error('Error fetching user data:', error);
    //   }
    // };
    
    const fetchUserData = async () => {
      try {
        const response = await fetch(`http://localhost:8081/api-v2/employee/${user.employeeId}`);
        const userData = await response.json();
        
        // Convert array of user data to an object
        const userObject = {};
        userData.employeeExperience.forEach((experience, index) => {
          userObject[index] = experience;
        });
    
        console.log(userObject);
        setUser(userObject);
        // Set edited user data initially with fetched user data
        setEditedUser(userData);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };
    
  return (
        <div style={{position:"absolute", marginTop:"-570px", marginLeft:"479px"}} className='Details_container_Experience'>

            <div className='Details'>
              <div style={{ marginTop: '40px' }}></div>
              {/* <div style={{ display: 'flex', paddingBottom: '20px' }}>
                <label>Employee ID :</label>
                <input style={{ marginLeft: '150px' }}
                  type='text'
                  placeholder='Employee ID'
                  value={user.employeeId}
                  readOnly
                />
              </div> */}
              {/* <hr className="badge-primary mt-2 w-10"></hr> */}
              <div style={{ display: 'flex', paddingBottom: '20px' }}>
                <label> CompanyName :</label>
                <input style={{ marginLeft: '170px' }}
                  type='text'
                  placeholder='Enter Company Name'
                  name="companyName"
                  value={editedUser.companyName}
                  onChange={handleInputChange}
                />
              </div>
              <hr className="badge-primary mt-2 w-10"></hr>
              <div style={{ display: 'flex', paddingBottom: '20px' }}>
                <label>designation :</label>
                <input style={{ marginLeft: '195px' }}
                  type='text'
                  placeholder='Enter Designation'
                  name="designation"
                  value={editedUser.designation}
                  onChange={handleInputChange}
                />
              </div>
              <hr className="badge-primary mt-2 w-10"></hr>
              <div style={{ display: 'flex', paddingBottom: '20px' }}>
                <label>Total Exp :</label>
                <input style={{ marginLeft: '220px' }}
                  type='text'
                  placeholder='Enter Total Exp'
                  name="totalExp"
                  value={editedUser.totalExp}
                  onChange={handleInputChange}
                />
              </div>
              
              <button style={{ float: 'right', width: '150px' }} className="btn btn-success" onClick={togglePopup}>Edit</button>
              {isPopupOpen && (
                <div id="popupOverlay" className="overlay-container show">
                  <div className="popup-box">
                    <form className="form-container">
                      <label className="form-label" >
                      Company Name:
                      </label>
                      <input
                        className="form-input"
                        type="text"
                        placeholder="Enter Company Name"
                        name="companyName"
                        value={editedUser.companyName}
                        onChange={handleInputChange}
                        required
                      />

                      <label className="form-label" >
                      Designation:
                      </label>
                      <input
                        className="form-input"
                        type="email"
                        placeholder="Enter Your designation"
                     
                        value={user.designation}
                        onChange={handleInputChange}
                        required
                      />

                      <label className="form-label" >
                      Total Exp:
                      </label>
                      <input
                        className="form-input"
                        type="text"
                        placeholder="Enter Your Total Exp"
                        name="totalExp"
                        value={editedUser.totalExp}
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
  );
}

export default Experience;