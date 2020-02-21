import * as React from 'react';
import * as ReactDOM from 'react-dom';
import {Voyager} from 'graphql-voyager';
import 'graphql-voyager/dist/voyager.css';

function introspectionProvider(query) {
  return fetch(window.location.origin + '/graphql', {
    method: 'post',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({query: query}),
  }).then(response => response.json());
}

ReactDOM.render(<Voyager introspection={introspectionProvider} />, document.getElementById('root'));
