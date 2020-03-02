import React from 'react';

class Content extends React.Component {
  componentDidMount() {
    fetch('http://localhost/articles', {
      method: 'GET'
    })
    .then(resp => resp.text())
    .then(text => console.log(text));
  }

  render() {
    return (
      <div className="col">
        <div className="col-10 offset-1" style={{ paddingTop: '5vh' }}>
          <table className="table table-bordered">
            <thead className="thead-light">
              <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default Content;
