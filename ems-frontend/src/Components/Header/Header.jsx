import React from "react";
import tecstaq_logo from "../assets/tecstaq_logo.jpg";
import "./Header.css";

const Header = ({ isDashboard, isAddLeadsPage, isRegistrationPage }) => {
  return (
    <div className="header">
      <nav
        className={`navbar navbar-expand-lg navbar-light ${
          isDashboard ? "dashboard-navbar" : "bg-light"
        }`}
      >
        <a className="navbar-brand" href="/">
          <img src={tecstaq_logo} alt="Tecstaq Logo" height="30" />
        </a>

        <div className="auth-links">
          {isDashboard ? (
            <>
              <span className="welcome-text">Welcome</span>
              <a href="/home" className="nav-link">
                Home
              </a>
              <a href="/notifications" className="nav-link">
                Notifications
              </a>
              {!isAddLeadsPage && (
                <a href="/add-lead" className="nav-link">
                  Add Lead
                </a>
              )}
              <a href="/login" className="nav-link logout-link">
                Logout
              </a>
            </>
          ) : isRegistrationPage ? null : ( // Render nothing when on the registration page
            <>
              <a href="/register" className="nav-link register-link">
                Register
              </a>
              <a href="/login" className="nav-link login-link">
                Login
              </a>
            </>
          )}
        </div>
      </nav>
    </div>
  );
};

export default Header;
