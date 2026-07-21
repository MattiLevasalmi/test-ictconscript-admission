import Grid from '@mui/material/Grid';
import './App.css';
import EntryCard from './components/entryCard';
import type { Entry } from './types/entryType';

const entryOne: Entry = {
  id: '1',
  title: 'This is the first entry',
  body: 'Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus.',
  isoTime: '0000-00-00 00:00:00',
  lat: 20.0123,
  lon: 20.0123
};
const entryTwo: Entry = {
  id: '2',
  title: 'This is the second entry',
  body: 'Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus.',
  isoTime: '0000-00-00 00:00:00'
};

function App() {
  return (
    <>
      <section id="center">
        <div>
          <h1>Unit Logbook</h1>
          <p>
            Edit <code>src/App.tsx</code> and save to test <code>HMR</code>
          </p>
        </div>
        <button
          type="button"
          className="button"
          onClick={() => alert('New entry model will be added here!')}>
          New Entry
        </button>
      </section>

      <section id="entries">
        <Grid container spacing={2}>
          {[entryOne, entryTwo].map((entry) => (
            <Grid key={entry.id} size={{ xs: 12, md: 6 }}>
              <EntryCard {...entry} />
            </Grid>
          ))}
        </Grid>
      </section>

      <section id="spacer"></section>
    </>
  );
}

export default App;
