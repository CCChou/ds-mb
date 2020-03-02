import React from 'react';

class UserConfig extends React.Component {
  render() {
    return (
      <div className="col">
        <div className="col-10 offset-1" style={{ paddingTop: '5vh' }}>
          <div className="card">
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label htmlFor="name">UserName</label>
                  <input
                    type="text"
                    className="form-control"
                    id="name"
                    aria-describedby="emailHelp"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password">Password</label>
                  <input type="password" className="form-control" id="password" />
                </div>
                <div className="form-group">
                  <label htmlFor="repassword">RePassword</label>
                  <input type="password" className="form-control" id="repassword" />
                </div>
                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default UserConfig;
