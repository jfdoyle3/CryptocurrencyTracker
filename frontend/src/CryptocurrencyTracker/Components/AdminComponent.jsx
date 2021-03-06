import React, { Component } from "react";
import { Link } from "react-router-dom";
import HelloWorldService from "../API/HelloWorldService.js";
import "../Styling/css/TestPage.css";

class TestPageComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      welcomeMessage: "",
    };

    this.handleSuccessfulResponse = this.handleSuccessfulResponse.bind(this);
    this.handleError = this.handleError.bind(this);
    this.retrieveWelcomeMessage = this.retrieveWelcomeMessage.bind(this);
  }

  handleError(error) {
    console.log(error.response);
    let errorMessage = "";
    if (error.message) errorMessage += error.message;

    if (error.response && error.response.data) {
      errorMessage += error.response.data.message;
    }
    this.setState({ welcomeMessage: errorMessage });
  }

  handleSuccessfulResponse(response) {
    console.log(response);
    this.setState({ welcomeMessage: response.data.message });
  }

  retrieveWelcomeMessage() {
    HelloWorldService.executeHelloWorldService().then((response) =>
      this.handleSuccessfulResponse(response)
    );

    HelloWorldService.executeHelloWorldBeanService().then((response) =>
      this.handleSuccessfulResponse(response)
    );

    HelloWorldService.executeHelloWorldPathVariableService(
      this.props.match.params.name
    )
      .then((response) => this.handleSuccessfulResponse(response))
      .catch((error) => this.handleError(error));
  }

  render() {
    return (
      <main>
        <div>
          <h1>Admin Page</h1>
          <div className="container">
            Admin {this.props.match.params.name} has logged in. <br />
            Pages: <br />
            <Link to="/list">Currency</Link>
            <br />
            <Link to="/details">Currency Details</Link>
          </div>
          <br />
          <div className="container">
            Click button to confirm back end is working
            <br />
            <button
              onClick={this.retrieveWelcomeMessage}
              className="btn btn-success"
            >
              Test Back end
            </button>
          </div>
          <div className="container">{this.state.welcomeMessage}</div>
        </div>
      </main>
    );
  }
}

export default TestPageComponent;
