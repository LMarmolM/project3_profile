import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import axios from 'axios';

function App() {
  const [imgLink, setimgLink] = useState("");
  const [profileId, setprofileId] = useState(2);

  function onChangeHandler(e) {
    setprofileId(e.target.value);
  }

  function onSubmitHandler(e) {
    e.preventDefault();
    var formData = new FormData();
    var imagefile = document.getElementById('fileInput');
    formData.append("image", imagefile.files[0]);
    axios.post('http://localhost:9007/profiles/' + profileId + '/profile_pic', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(response => {
        console.log(response.data);
        setimgLink(response.data);
      })
      .catch(error => console.error(error));

  }

  return (
    <div className="App">
      <h1>Pic Upload Form</h1>
      <form onSubmit={onSubmitHandler}>
        <label htmlFor="fileInput">Select a image file for profile pic</label>
        <input type="file" id="fileInput" name="image" accept="image/png, image/gif, image/jpeg" />
        <input type="submit" />
      </form>

      <img id="img-test-preview" src={imgLink} height="200" width="auto"/>
    </div>
  );
}

export default App;
