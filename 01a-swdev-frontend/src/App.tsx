import Grid from '@mui/material/Grid';
import './App.css';
import EntryCard from './components/entryCard';
import type { Entry } from './types/entryType';
import { useState } from 'react';
import data from '../../sample-data/data.json';
import Modal from '@mui/material/Modal';
import NewEntryCard from './components/newEntryCard';

function App() {
  const [entries, setEntries] = useState<Array<Entry>>(data as Array<Entry>);
  const [modalState, setModalState] = useState<boolean>(false);

  const addEntry = (newEntry: Entry) => {
    const highestId = Math.max(0, ...entries.map((entry) => Number(entry.id)));
    newEntry.id = `${highestId + 1}`;
    newEntry.isoTime = new Date().toISOString();
    setEntries(entries.concat(newEntry));
  };
  const handleOpen = () => {
    setModalState(true);
  };
  const handleClose = () => {
    setModalState(false);
  };

  return (
    <>
      <section id="center">
        <div>
          <h1>Unit Logbook</h1>
        </div>
        <button type="button" className="button" onClick={handleOpen}>
          New Entry
        </button>
        <Modal open={modalState}>
          <NewEntryCard addEntry={addEntry} handleClose={handleClose} />
        </Modal>
      </section>

      <section id="entries">
        <Grid container spacing={2}>
          {entries
            .sort((a, b) => Date.parse(b.isoTime) - Date.parse(a.isoTime))
            .map((entry) => (
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
