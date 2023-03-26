<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./style.css" />
    <title>Document</title>
  </head>
  <body
    style="
      background-image: url(https://img.freepik.com/free-vector/copy-space-bokeh-spring-lights-background_52683-55649.jpg?w=2000);
      background-size: cover;
      padding: 5rem;
    "
  >
    <div
      style="
        display: grid;
        grid-template-columns: 1fr 1fr;
        justify-items: center;
        background-color: #7cc052;
        opacity: 0.89;
        border-radius: 4rem;
        padding: 5rem;
      "
    >
      <div style="justify-self: center; margin: 3rem 0">
        <img
          style="border-radius: 8rem"
          src="https://cdn.xxl.thumbs.canstockphoto.com/register-now-button-register-now-rounded-green-sign-register-now-image_csp73372272.jpg"
          alt="log in"
        />
      </div>
      <form
        action="servlet1"
        method="post"
        style="display: grid; row-gap: 1rem"
      >
        <h1 style="font-family: cursive; text-align: center">
          Register to Log In
        </h1>
        <div style="justify-self: center">
          <label style="margin-right: 0.5rem" for="firstname"
            >First Name:</label
          >
          <input
            style="
              padding: 0.3rem 1rem;
              border: none;
              border-radius: 2rem;
              background: rgb(235 227 227);
            "
            type="text"
            name="firstname"
            id="firstname"
          />
        </div>
        <div style="justify-self: center">
          <label style="margin-right: 0.5rem" for="lastname">Last Name:</label>
          <input
            style="
              padding: 0.3rem 1rem;
              border: none;
              border-radius: 2rem;
              background: rgb(235 227 227);
            "
            type="text"
            name="lastname"
            id="lastname"
          />
        </div>
        <div style="justify-self: center">
          <label style="margin-right: 0.5rem" for="username">UserName:</label>
          <input
            style="
              padding: 0.3rem 1rem;
              border: none;
              border-radius: 2rem;
              background: rgb(235 227 227);
            "
            type="text"
            name="username"
            id="username"
          />
        </div>
        <div style="justify-self: center">
          <label style="margin-right: 0.7rem" for="password">Password:</label>
          <input
            style="
              padding: 0.3rem 1rem;
              border: none;
              border-radius: 2rem;
              background: rgb(235 227 227);
            "
            type="text"
            name="password"
            id="password"
          />
        </div>
        <div
          style="
            display: flex;
            gap: 5rem;
            align-items: center;
            padding: 0 5.5rem;
          "
        >
          <button
            style="
              padding: 0.3rem 1rem;
              border: none;
              border-radius: 2rem;
              background: wheat;
              width: 5rem;
            "
            href="/"
          >
            Login
          </button>
          <button
            style="
              padding: 0.3rem 1rem;
              border: none;
              border-radius: 2rem;
              background: wheat;
              width: 5rem;
            "
            type="submit"
            value="Register"
          >
            Register
          </button>
        </div>
      </form>
    </div>
  </body>
</html>
