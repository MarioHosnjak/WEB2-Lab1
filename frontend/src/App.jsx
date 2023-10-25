import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import HomePage from "./screens/HomePage";
import ProfilePage from "./screens/ProfilePage";

function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/" element={<HomePage></HomePage>} />
          <Route path="/profile" element={<ProfilePage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
